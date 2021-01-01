package resharker.jiracli

import kotlinx.cinterop.toKString
import platform.posix.getenv

inline fun requireEnv(key: String): String =
    requireNotNull(getenv(key)) { "Environmental variable $key is required" }.toKString()
