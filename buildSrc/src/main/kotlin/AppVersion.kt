object AppVersion {
    private const val major = 2
    private const val minor = 10
    private const val patch = 3

    const val buildVersion = 8

    // MAX version code 2000000000
    //                   111122233
    //    xx1   12    22
    //  major minor patch
    const val code = major * 1000000 + minor * 10000 + patch * 100 + buildVersion
    val name = "$major.$minor.$patch"
}
