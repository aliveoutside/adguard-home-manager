package ru.toxyxd.adguardhome.domain.model.logs

enum class LogReason {
    NotFilteredNotFound,
    NotFilteredWhiteList,
    NotFilteredError,

    FilteredBlackList,
    FilteredSafeBrowsing,
    FilteredParental,
    FilteredInvalid,
    FilteredSafeSearch,
    FilteredBlockedService,

    Rewrite,
    RewriteEtcHosts,
    RewriteRule
}