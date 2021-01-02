package resharker.jiracli

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class JiraIssue(
    @SerialName("expand")
    val expand: String,
    @SerialName("fields")
    val fields: Fields,
    @SerialName("id")
    val id: String,
    @SerialName("key")
    val key: String,
    @SerialName("self")
    val self: String
) {
    @Serializable
    data class Fields(
        @SerialName("aggregateprogress")
        val aggregateprogress: Aggregateprogress,
        @SerialName("aggregatetimeestimate")
        val aggregatetimeestimate: Int,
        @SerialName("aggregatetimeoriginalestimate")
        val aggregatetimeoriginalestimate: Int,
        @SerialName("aggregatetimespent")
        val aggregatetimespent: String?,
        @SerialName("assignee")
        val assignee: Assignee,
        @SerialName("attachment")
        val attachment: List<String>,
        @SerialName("comment")
        val comment: Comment,
        @SerialName("components")
        val components: List<String>,
        @SerialName("created")
        val created: String,
        @SerialName("creator")
        val creator: Creator,
        @SerialName("description")
        val description: String,
        @SerialName("duedate")
        val duedate: String?,
        @SerialName("environment")
        val environment: String?,
        @SerialName("fixVersions")
        val fixVersions: List<String>,
        @SerialName("issuelinks")
        val issuelinks: List<Issuelink>,
        @SerialName("issuerestriction")
        val issuerestriction: Issuerestriction,
        @SerialName("issuetype")
        val issuetype: Issuetype,
        @SerialName("labels")
        val labels: List<String>,
        @SerialName("lastViewed")
        val lastViewed: String?,
        @SerialName("priority")
        val priority: Priority,
        @SerialName("progress")
        val progress: Progress,
        @SerialName("project")
        val project: Project,
        @SerialName("reporter")
        val reporter: Reporter,
        @SerialName("resolution")
        val resolution: Resolution,
        @SerialName("resolutiondate")
        val resolutiondate: String,
        @SerialName("security")
        val security: String?,
        @SerialName("status")
        val status: Status,
        @SerialName("statuscategorychangedate")
        val statuscategorychangedate: String,
        @SerialName("subtasks")
        val subtasks: List<String>,
        @SerialName("summary")
        val summary: String,
        @SerialName("timeestimate")
        val timeestimate: Int,
        @SerialName("timeoriginalestimate")
        val timeoriginalestimate: Int,
        @SerialName("timespent")
        val timespent: String?,
        @SerialName("timetracking")
        val timetracking: Timetracking,
        @SerialName("updated")
        val updated: String,
        @SerialName("versions")
        val versions: List<String>,
        @SerialName("votes")
        val votes: Votes,
        @SerialName("watches")
        val watches: Watches,
        @SerialName("worklog")
        val worklog: Worklog,
        @SerialName("workratio")
        val workratio: Int
    ) {
        @Serializable
        data class Aggregateprogress(
            @SerialName("percent")
            val percent: Int,
            @SerialName("progress")
            val progress: Int,
            @SerialName("total")
            val total: Int
        )

        @Serializable
        data class Assignee(
            @SerialName("accountId")
            val accountId: String,
            @SerialName("accountType")
            val accountType: String,
            @SerialName("active")
            val active: Boolean,
            @SerialName("avatarUrls")
            val avatarUrls: AvatarUrls,
            @SerialName("displayName")
            val displayName: String,
            @SerialName("self")
            val self: String,
            @SerialName("timeZone")
            val timeZone: String
        ) {
            @Serializable
            data class AvatarUrls(
                @SerialName("16x16")
                val x16: String,
                @SerialName("24x24")
                val x24: String,
                @SerialName("32x32")
                val x32: String,
                @SerialName("48x48")
                val x48: String
            )
        }

        @Serializable
        data class Comment(
            @SerialName("comments")
            val comments: List<String>,
            @SerialName("maxResults")
            val maxResults: Int,
            @SerialName("startAt")
            val startAt: Int,
            @SerialName("total")
            val total: Int
        )

        @Serializable
        data class Creator(
            @SerialName("accountId")
            val accountId: String,
            @SerialName("accountType")
            val accountType: String,
            @SerialName("active")
            val active: Boolean,
            @SerialName("avatarUrls")
            val avatarUrls: AvatarUrls,
            @SerialName("displayName")
            val displayName: String,
            @SerialName("self")
            val self: String,
            @SerialName("timeZone")
            val timeZone: String
        ) {
            @Serializable
            data class AvatarUrls(
                @SerialName("16x16")
                val x16: String,
                @SerialName("24x24")
                val x24: String,
                @SerialName("32x32")
                val x32: String,
                @SerialName("48x48")
                val x48: String
            )
        }

        @Serializable
        data class Customfield10019(
            @SerialName("boardId")
            val boardId: Int,
            @SerialName("completeDate")
            val completeDate: String,
            @SerialName("endDate")
            val endDate: String,
            @SerialName("goal")
            val goal: String,
            @SerialName("id")
            val id: Int,
            @SerialName("name")
            val name: String,
            @SerialName("startDate")
            val startDate: String,
            @SerialName("state")
            val state: String
        )

        @Serializable
        data class Customfield10308(
            @SerialName("id")
            val id: String,
            @SerialName("self")
            val self: String,
            @SerialName("value")
            val value: String
        )

        @Serializable
        data class Customfield10309(
            @SerialName("id")
            val id: String,
            @SerialName("self")
            val self: String,
            @SerialName("value")
            val value: String
        )

        @Serializable
        data class Customfield10900(
            @SerialName("hasEpicLinkFieldDependency")
            val hasEpicLinkFieldDependency: Boolean,
            @SerialName("nonEditableReason")
            val nonEditableReason: NonEditableReason,
            @SerialName("showField")
            val showField: Boolean
        ) {
            @Serializable
            data class NonEditableReason(
                @SerialName("message")
                val message: String,
                @SerialName("reason")
                val reason: String
            )
        }

        @Serializable
        data class Issuelink(
            @SerialName("id")
            val id: String,
            @SerialName("inwardIssue")
            val inwardIssue: InwardIssue,
            @SerialName("self")
            val self: String,
            @SerialName("type")
            val type: Type
        ) {
            @Serializable
            data class InwardIssue(
                @SerialName("fields")
                val fields: Fields,
                @SerialName("id")
                val id: String,
                @SerialName("key")
                val key: String,
                @SerialName("self")
                val self: String
            ) {
                @Serializable
                data class Fields(
                    @SerialName("issuetype")
                    val issuetype: Issuetype,
                    @SerialName("priority")
                    val priority: Priority,
                    @SerialName("status")
                    val status: Status,
                    @SerialName("summary")
                    val summary: String
                ) {
                    @Serializable
                    data class Issuetype(
                        @SerialName("avatarId")
                        val avatarId: Int,
                        @SerialName("description")
                        val description: String,
                        @SerialName("iconUrl")
                        val iconUrl: String,
                        @SerialName("id")
                        val id: String,
                        @SerialName("name")
                        val name: String,
                        @SerialName("self")
                        val self: String,
                        @SerialName("subtask")
                        val subtask: Boolean
                    )

                    @Serializable
                    data class Priority(
                        @SerialName("iconUrl")
                        val iconUrl: String,
                        @SerialName("id")
                        val id: String,
                        @SerialName("name")
                        val name: String,
                        @SerialName("self")
                        val self: String
                    )

                    @Serializable
                    data class Status(
                        @SerialName("description")
                        val description: String,
                        @SerialName("iconUrl")
                        val iconUrl: String,
                        @SerialName("id")
                        val id: String,
                        @SerialName("name")
                        val name: String,
                        @SerialName("self")
                        val self: String,
                        @SerialName("statusCategory")
                        val statusCategory: StatusCategory
                    ) {
                        @Serializable
                        data class StatusCategory(
                            @SerialName("colorName")
                            val colorName: String,
                            @SerialName("id")
                            val id: Int,
                            @SerialName("key")
                            val key: String,
                            @SerialName("name")
                            val name: String,
                            @SerialName("self")
                            val self: String
                        )
                    }
                }
            }

            @Serializable
            data class Type(
                @SerialName("id")
                val id: String,
                @SerialName("inward")
                val inward: String,
                @SerialName("name")
                val name: String,
                @SerialName("outward")
                val outward: String,
                @SerialName("self")
                val self: String
            )
        }

        @Serializable
        data class Issuerestriction(
            @SerialName("issuerestrictions")
            val issuerestrictions: Issuerestrictions,
            @SerialName("shouldDisplay")
            val shouldDisplay: Boolean
        ) {
            @Serializable
            class Issuerestrictions(
            )
        }

        @Serializable
        data class Issuetype(
            @SerialName("avatarId")
            val avatarId: Int,
            @SerialName("description")
            val description: String,
            @SerialName("iconUrl")
            val iconUrl: String,
            @SerialName("id")
            val id: String,
            @SerialName("name")
            val name: String,
            @SerialName("self")
            val self: String,
            @SerialName("subtask")
            val subtask: Boolean
        )

        @Serializable
        data class Priority(
            @SerialName("iconUrl")
            val iconUrl: String,
            @SerialName("id")
            val id: String,
            @SerialName("name")
            val name: String,
            @SerialName("self")
            val self: String
        )

        @Serializable
        data class Progress(
            @SerialName("percent")
            val percent: Int,
            @SerialName("progress")
            val progress: Int,
            @SerialName("total")
            val total: Int
        )

        @Serializable
        data class Project(
            @SerialName("avatarUrls")
            val avatarUrls: AvatarUrls,
            @SerialName("id")
            val id: String,
            @SerialName("key")
            val key: String,
            @SerialName("name")
            val name: String,
            @SerialName("projectTypeKey")
            val projectTypeKey: String,
            @SerialName("self")
            val self: String,
            @SerialName("simplified")
            val simplified: Boolean
        ) {
            @Serializable
            data class AvatarUrls(
                @SerialName("16x16")
                val x16: String,
                @SerialName("24x24")
                val x24: String,
                @SerialName("32x32")
                val x32: String,
                @SerialName("48x48")
                val x48: String
            )
        }

        @Serializable
        data class Reporter(
            @SerialName("accountId")
            val accountId: String,
            @SerialName("accountType")
            val accountType: String,
            @SerialName("active")
            val active: Boolean,
            @SerialName("avatarUrls")
            val avatarUrls: AvatarUrls,
            @SerialName("displayName")
            val displayName: String,
            @SerialName("self")
            val self: String,
            @SerialName("timeZone")
            val timeZone: String
        ) {
            @Serializable
            data class AvatarUrls(
                @SerialName("16x16")
                val x16: String,
                @SerialName("24x24")
                val x24: String,
                @SerialName("32x32")
                val x32: String,
                @SerialName("48x48")
                val x48: String
            )
        }

        @Serializable
        data class Resolution(
            @SerialName("description")
            val description: String,
            @SerialName("id")
            val id: String,
            @SerialName("name")
            val name: String,
            @SerialName("self")
            val self: String
        )

        @Serializable
        data class Status(
            @SerialName("description")
            val description: String,
            @SerialName("iconUrl")
            val iconUrl: String,
            @SerialName("id")
            val id: String,
            @SerialName("name")
            val name: String,
            @SerialName("self")
            val self: String,
            @SerialName("statusCategory")
            val statusCategory: StatusCategory
        ) {
            @Serializable
            data class StatusCategory(
                @SerialName("colorName")
                val colorName: String,
                @SerialName("id")
                val id: Int,
                @SerialName("key")
                val key: String,
                @SerialName("name")
                val name: String,
                @SerialName("self")
                val self: String
            )
        }

        @Serializable
        data class Timetracking(
            @SerialName("originalEstimate")
            val originalEstimate: String,
            @SerialName("originalEstimateSeconds")
            val originalEstimateSeconds: Int,
            @SerialName("remainingEstimate")
            val remainingEstimate: String,
            @SerialName("remainingEstimateSeconds")
            val remainingEstimateSeconds: Int
        )

        @Serializable
        data class Votes(
            @SerialName("hasVoted")
            val hasVoted: Boolean,
            @SerialName("self")
            val self: String,
            @SerialName("votes")
            val votes: Int
        )

        @Serializable
        data class Watches(
            @SerialName("isWatching")
            val isWatching: Boolean,
            @SerialName("self")
            val self: String,
            @SerialName("watchCount")
            val watchCount: Int
        )

        @Serializable
        data class Worklog(
            @SerialName("maxResults")
            val maxResults: Int,
            @SerialName("startAt")
            val startAt: Int,
            @SerialName("total")
            val total: Int,
            @SerialName("worklogs")
            val worklogs: List<String>
        )
    }
}
