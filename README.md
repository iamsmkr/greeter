# greeter

[![CI Workflow](https://github.com/iamsmkr/greeter/actions/workflows/ci.yml/badge.svg)](https://github.com/iamsmkr/greeter/actions/workflows/ci.yml)
[![codecov](https://codecov.io/gh/iamsmkr/greeter/branch/main/graph/badge.svg?token=01E1X7VC4I)](https://codecov.io/gh/iamsmkr/greeter)
![GitHub](https://img.shields.io/github/license/iamsmkr/greeter)

This project aims to demonstrates building complete CI/CD workflow using GitHub Actions which includes following agenda:
- Automate unit/integration testing
- Validate code formatting
- Add code owners to review code
- Create release drafts and publish them
- Upload artifacts to Sonatype OSSRH and subsequently to Maven Central
- Upload code coverage reports on Codecov.io
- Notify release on Slack

**Notes:**

- With following issue, I was able to secure the namespace `com.shivamkapoor` in Sonatype OSSRH (Open Source Software Repository Hosting).

    https://issues.sonatype.org/browse/OSSRH-71578
    

## Configurations
1. Install GnuPG and verify the installation

    Refer: https://www.gnupg.org/download/
    
    ```sh
    $ gpg --version

    gpg (GnuPG/MacGPG2) 2.2.8
    libgcrypt 1.8.3
    Copyright (C) 2018 Free Software Foundation, Inc.
    License GPLv3+: GNU GPL version 3 or later <https://gnu.org/licenses/gpl.html>
    ```

2. Generate a key

    A key pair allows you to sign artifacts with GPG and users can subsequently validate that artifacts have been signed by you. You can generate a key with:
    ```sh
    $ gpg --gen-key
    ```

3. List the keys

    Once key pair is generated, we can list them along with any other keys installed:
    
    ```sh
    $ gpg --list-keys

    /home/foo/.gnupg/pubring.gpg
    ------------------------------

    pub   rsa4096 2018-08-22 [SC]
        1234517530FB96F147C6A146A326F592D39AAAAA
    uid           [ultimate] your name <you@example.com>
    sub   rsa4096 2018-08-22 [E]
    ```

4. Distribute the key and verify

    Since other people need your public key to verify your files, you have to distribute your public key to a key server:
    
    ```sh
    $ gpg --keyserver keyserver.ubuntu.com --send-keys 1234517530FB96F147C6A146A326F592D39AAAAA
    $ gpg --keyserver keyserver.ubuntu.com --search-keys 'mail@shivamkapoor.com'
    ```

5. Export secret keys for sbt

    ```sh
    $ gpg -a --export-secret-keys > ~/.sbt/gpg/secring.asc
    ```

6. Create Sonatype credentials file under `.sbt` and add following to that file:

    ```sh
    $ cat sonatype_credentials

    realm=Sonatype Nexus Repository Manager
    host=s01.oss.sonatype.org
    user=<your username>
    password=<your password>
    ```

7. Create `sonatype.sbt` and add location to sonatype credentials

    This lets sbt know what credentials to use to access sonatype OSSRH.
    
    ```sh
    $ cat ~/.sbt/1.0/sonatype.sbt
    credentials += Credentials(Path.userHome / ".sbt" / "sonatype_credentials")
    ```

## Publish
Publish artifacts to nexus repository
```sh
$ sbt publishSigned
```

## Release
In order to release artifacts against a version, go to staging repository, select the repository, close it and then release.

[![Screenshot-2022-05-06-at-12-48-50-PM.png](https://i.postimg.cc/8PHzDSHF/Screenshot-2022-05-06-at-12-48-50-PM.png)](https://postimg.cc/MvnSbggx)

## References
- [Publish Guide](https://central.sonatype.org/publish/publish-guide/)
- [SBT Sonatype](https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html)
- [How to publish scala module in sonatype and maven?](https://stackoverflow.com/questions/57072002/how-to-publish-scala-module-in-sonatype-and-maven)
- [How to Publish a Java Library to Maven Central](https://www.youtube.com/watch?v=bxP9IuJbcDQ&ab_channel=Recursive)
- [Nexus Repository Tutorial](https://www.youtube.com/watch?v=yZFvJEygn_g&ab_channel=Intellipaat)
