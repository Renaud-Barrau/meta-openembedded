SUMMARY = "Recipe for drm-lease-manager"
HOMEPAGE = "https://github.com/AGLExport/drm-lease-manager"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRC_URI = "git://git.automotivelinux.org/src/drm-lease-manager;protocol=https;branch=master"

SRCREV = "8ec09a65cd5b390b3d24bfb6c7a73993a3d98a56"

S = "${WORKDIR}/git"

inherit meson pkgconfig

DEPENDS += "libdrm libtoml"

# Change default path /var/run/drm-lease-manager.
# For exemple if you wish to move the runtime dir of drm-lease-manager to /etc :
EXTRA_OEMESON += "-Druntime_subdir=/etc/drm-lease-manager"

FILES:${PN} += "${bindir}/drm-lease-manager"
FILES:${PN} += "/etc/drm-lease-manager"