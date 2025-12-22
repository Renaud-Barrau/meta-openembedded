SUMMARY = "TOML parser in C"
HOMEPAGE = "https://github.com/cktan/tomlc99"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=95bbe2f9180443b5dcef3fb959804a65"

SRC_URI = "git://github.com/cktan/tomlc99;protocol=https;branch=master"

SRCREV = "26b9c1ea770dab2378e5041b695d24ccebe58a7a"

S = "${WORKDIR}/git"

inherit pkgconfig

do_compile() {
    oe_runmake CC="${CC}"
}

do_install() {
    install -d ${D}${includedir}
    install -m 0644 toml.h ${D}${includedir}/

    install -d ${D}${libdir}
    install -m 0644 libtoml.a ${D}${libdir}/
}

do_install:append() {
    install -d ${D}${libdir}/pkgconfig

    cat << EOF > ${D}${libdir}/pkgconfig/libtoml.pc
prefix=${prefix}
exec_prefix=${exec_prefix}
includedir=${includedir}
libdir=${libdir}

Name: libtoml
Description: TOML parser in C (tomlc99)
Version: 1.0
Libs: -L\${libdir} -ltoml
Cflags: -I\${includedir}
EOF
}
