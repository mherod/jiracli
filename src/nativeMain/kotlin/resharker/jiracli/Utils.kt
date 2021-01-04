package resharker.jiracli

inline infix fun String.requireMatch(regexString: String) = require(matches(regexString.toRegex()))
