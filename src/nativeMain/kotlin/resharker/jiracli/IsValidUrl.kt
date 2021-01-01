package resharker.jiracli

fun isValidUrl(url: String) = url.matches("https?://\\S+".toRegex())
