package api.response

data class ProblemResponse (val type: String, val title: String?, val status: Int?, val detail: String?, val instance: String?) {
}