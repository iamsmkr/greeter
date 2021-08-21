# greeter

[![CI Workflow](https://github.com/iamsmkr/greeter/actions/workflows/ci.yml/badge.svg)](https://github.com/iamsmkr/greeter/actions/workflows/ci.yml)
[![codecov](https://codecov.io/gh/iamsmkr/greeter/branch/main/graph/badge.svg?token=01E1X7VC4I)](https://codecov.io/gh/iamsmkr/greeter)

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
