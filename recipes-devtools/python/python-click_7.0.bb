SUMMARY = "A simple wrapper around optparse for powerful command line utilities."
DESCRIPTION = "\
Click is a Python package for creating beautiful command line interfaces \
in a composable way with as little code as necessary. It's the "Command \
Line Interface Creation Kit". It's highly configurable but comes with \
sensible defaults out of the box."
HOMEPAGE = "https://palletsprojects.com/p/click/"
BUGTRACKER = "https://github.com/pallets/click/issues"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.rst;md5=c13ed890b210a882c1778216694c98c7"

SRC_URI[md5sum] = "7f53d50f7b7373ebc7963f9ff697450a"
SRC_URI[sha256sum] = "5b94b49521f6456670fdb30cd82a4eca9412788a93fa6dd6df72c94d5a8ff2d7"

UPSTREAM_CHECK_REGEX = "click/(?P<pver>\d+(\.\d+)+)/"

CLEANBROKEN = "1"

PYPI_PACKAGE = "Click"

inherit pypi setuptools

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-contextlib \
    ${PYTHON_PN}-io \
    ${PYTHON_PN}-threading \
    "

BBCLASSEXTEND = "native nativesdk"

PNBLACKLIST[python-click] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
