
package com.ciklum.model;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "archive_url",
    "assignees_url",
    "blobs_url",
    "branches_url",
    "clone_url",
    "collaborators_url",
    "comments_url",
    "commits_url",
    "compare_url",
    "contents_url",
    "contributors_url",
    "created_at",
    "default_branch",
    "deployments_url",
    "description",
    "downloads_url",
    "events_url",
    "fork",
    "forks",
    "forks_count",
    "forks_url",
    "full_name",
    "git_commits_url",
    "git_refs_url",
    "git_tags_url",
    "git_url",
    "has_downloads",
    "has_issues",
    "has_pages",
    "has_projects",
    "has_wiki",
    "homepage",
    "hooks_url",
    "html_url",
    "id",
    "issue_comment_url",
    "issue_events_url",
    "issues_url",
    "keys_url",
    "labels_url",
    "language",
    "languages_url",
    "merges_url",
    "milestones_url",
    "mirror_url",
    "name",
    "notifications_url",
    "open_issues",
    "open_issues_count",
    "owner",
    "private",
    "pulls_url",
    "pushed_at",
    "releases_url",
    "size",
    "ssh_url",
    "stargazers_count",
    "stargazers_url",
    "statuses_url",
    "subscribers_url",
    "subscription_url",
    "svn_url",
    "tags_url",
    "teams_url",
    "trees_url",
    "updated_at",
    "url",
    "watchers",
    "watchers_count"
})
public class Repo {

    @JsonProperty("archive_url")
    private String archiveUrl;
    @JsonProperty("assignees_url")
    private String assigneesUrl;
    @JsonProperty("blobs_url")
    private String blobsUrl;
    @JsonProperty("branches_url")
    private String branchesUrl;
    @JsonProperty("clone_url")
    private String cloneUrl;
    @JsonProperty("collaborators_url")
    private String collaboratorsUrl;
    @JsonProperty("comments_url")
    private String commentsUrl;
    @JsonProperty("commits_url")
    private String commitsUrl;
    @JsonProperty("compare_url")
    private String compareUrl;
    @JsonProperty("contents_url")
    private String contentsUrl;
    @JsonProperty("contributors_url")
    private String contributorsUrl;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("default_branch")
    private String defaultBranch;
    @JsonProperty("deployments_url")
    private String deploymentsUrl;
    @JsonProperty("description")
    private String description;
    @JsonProperty("downloads_url")
    private String downloadsUrl;
    @JsonProperty("events_url")
    private String eventsUrl;
    @JsonProperty("fork")
    private Boolean fork;
    @JsonProperty("forks")
    private Integer forks;
    @JsonProperty("forks_count")
    private Integer forksCount;
    @JsonProperty("forks_url")
    private String forksUrl;
    @JsonProperty("full_name")
    private String fullName;
    @JsonProperty("git_commits_url")
    private String gitCommitsUrl;
    @JsonProperty("git_refs_url")
    private String gitRefsUrl;
    @JsonProperty("git_tags_url")
    private String gitTagsUrl;
    @JsonProperty("git_url")
    private String gitUrl;
    @JsonProperty("has_downloads")
    private Boolean hasDownloads;
    @JsonProperty("has_issues")
    private Boolean hasIssues;
    @JsonProperty("has_pages")
    private Boolean hasPages;
    @JsonProperty("has_projects")
    private Boolean hasProjects;
    @JsonProperty("has_wiki")
    private Boolean hasWiki;
    @JsonProperty("homepage")
    private Object homepage;
    @JsonProperty("hooks_url")
    private String hooksUrl;
    @JsonProperty("html_url")
    private String htmlUrl;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("issue_comment_url")
    private String issueCommentUrl;
    @JsonProperty("issue_events_url")
    private String issueEventsUrl;
    @JsonProperty("issues_url")
    private String issuesUrl;
    @JsonProperty("keys_url")
    private String keysUrl;
    @JsonProperty("labels_url")
    private String labelsUrl;
    @JsonProperty("language")
    private String language;
    @JsonProperty("languages_url")
    private String languagesUrl;
    @JsonProperty("merges_url")
    private String mergesUrl;
    @JsonProperty("milestones_url")
    private String milestonesUrl;
    @JsonProperty("mirror_url")
    private Object mirrorUrl;
    @JsonProperty("name")
    private String name;
    @JsonProperty("notifications_url")
    private String notificationsUrl;
    @JsonProperty("open_issues")
    private Integer openIssues;
    @JsonProperty("open_issues_count")
    private Integer openIssuesCount;
    @JsonProperty("owner")
    private Owner owner;
    @JsonProperty("private")
    private Boolean _private;
    @JsonProperty("pulls_url")
    private String pullsUrl;
    @JsonProperty("pushed_at")
    private String pushedAt;
    @JsonProperty("releases_url")
    private String releasesUrl;
    @JsonProperty("size")
    private Integer size;
    @JsonProperty("ssh_url")
    private String sshUrl;
    @JsonProperty("stargazers_count")
    private Integer stargazersCount;
    @JsonProperty("stargazers_url")
    private String stargazersUrl;
    @JsonProperty("statuses_url")
    private String statusesUrl;
    @JsonProperty("subscribers_url")
    private String subscribersUrl;
    @JsonProperty("subscription_url")
    private String subscriptionUrl;
    @JsonProperty("svn_url")
    private String svnUrl;
    @JsonProperty("tags_url")
    private String tagsUrl;
    @JsonProperty("teams_url")
    private String teamsUrl;
    @JsonProperty("trees_url")
    private String treesUrl;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonProperty("url")
    private String url;
    @JsonProperty("watchers")
    private Integer watchers;
    @JsonProperty("watchers_count")
    private Integer watchersCount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("archive_url")
    public String getArchiveUrl() {
        return archiveUrl;
    }

    @JsonProperty("archive_url")
    public void setArchiveUrl(String archiveUrl) {
        this.archiveUrl = archiveUrl;
    }

    @JsonProperty("assignees_url")
    public String getAssigneesUrl() {
        return assigneesUrl;
    }

    @JsonProperty("assignees_url")
    public void setAssigneesUrl(String assigneesUrl) {
        this.assigneesUrl = assigneesUrl;
    }

    @JsonProperty("blobs_url")
    public String getBlobsUrl() {
        return blobsUrl;
    }

    @JsonProperty("blobs_url")
    public void setBlobsUrl(String blobsUrl) {
        this.blobsUrl = blobsUrl;
    }

    @JsonProperty("branches_url")
    public String getBranchesUrl() {
        return branchesUrl;
    }

    @JsonProperty("branches_url")
    public void setBranchesUrl(String branchesUrl) {
        this.branchesUrl = branchesUrl;
    }

    @JsonProperty("clone_url")
    public String getCloneUrl() {
        return cloneUrl;
    }

    @JsonProperty("clone_url")
    public void setCloneUrl(String cloneUrl) {
        this.cloneUrl = cloneUrl;
    }

    @JsonProperty("collaborators_url")
    public String getCollaboratorsUrl() {
        return collaboratorsUrl;
    }

    @JsonProperty("collaborators_url")
    public void setCollaboratorsUrl(String collaboratorsUrl) {
        this.collaboratorsUrl = collaboratorsUrl;
    }

    @JsonProperty("comments_url")
    public String getCommentsUrl() {
        return commentsUrl;
    }

    @JsonProperty("comments_url")
    public void setCommentsUrl(String commentsUrl) {
        this.commentsUrl = commentsUrl;
    }

    @JsonProperty("commits_url")
    public String getCommitsUrl() {
        return commitsUrl;
    }

    @JsonProperty("commits_url")
    public void setCommitsUrl(String commitsUrl) {
        this.commitsUrl = commitsUrl;
    }

    @JsonProperty("compare_url")
    public String getCompareUrl() {
        return compareUrl;
    }

    @JsonProperty("compare_url")
    public void setCompareUrl(String compareUrl) {
        this.compareUrl = compareUrl;
    }

    @JsonProperty("contents_url")
    public String getContentsUrl() {
        return contentsUrl;
    }

    @JsonProperty("contents_url")
    public void setContentsUrl(String contentsUrl) {
        this.contentsUrl = contentsUrl;
    }

    @JsonProperty("contributors_url")
    public String getContributorsUrl() {
        return contributorsUrl;
    }

    @JsonProperty("contributors_url")
    public void setContributorsUrl(String contributorsUrl) {
        this.contributorsUrl = contributorsUrl;
    }

    @JsonProperty("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("created_at")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("default_branch")
    public String getDefaultBranch() {
        return defaultBranch;
    }

    @JsonProperty("default_branch")
    public void setDefaultBranch(String defaultBranch) {
        this.defaultBranch = defaultBranch;
    }

    @JsonProperty("deployments_url")
    public String getDeploymentsUrl() {
        return deploymentsUrl;
    }

    @JsonProperty("deployments_url")
    public void setDeploymentsUrl(String deploymentsUrl) {
        this.deploymentsUrl = deploymentsUrl;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("downloads_url")
    public String getDownloadsUrl() {
        return downloadsUrl;
    }

    @JsonProperty("downloads_url")
    public void setDownloadsUrl(String downloadsUrl) {
        this.downloadsUrl = downloadsUrl;
    }

    @JsonProperty("events_url")
    public String getEventsUrl() {
        return eventsUrl;
    }

    @JsonProperty("events_url")
    public void setEventsUrl(String eventsUrl) {
        this.eventsUrl = eventsUrl;
    }

    @JsonProperty("fork")
    public Boolean getFork() {
        return fork;
    }

    @JsonProperty("fork")
    public void setFork(Boolean fork) {
        this.fork = fork;
    }

    @JsonProperty("forks")
    public Integer getForks() {
        return forks;
    }

    @JsonProperty("forks")
    public void setForks(Integer forks) {
        this.forks = forks;
    }

    @JsonProperty("forks_count")
    public Integer getForksCount() {
        return forksCount;
    }

    @JsonProperty("forks_count")
    public void setForksCount(Integer forksCount) {
        this.forksCount = forksCount;
    }

    @JsonProperty("forks_url")
    public String getForksUrl() {
        return forksUrl;
    }

    @JsonProperty("forks_url")
    public void setForksUrl(String forksUrl) {
        this.forksUrl = forksUrl;
    }

    @JsonProperty("full_name")
    public String getFullName() {
        return fullName;
    }

    @JsonProperty("full_name")
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @JsonProperty("git_commits_url")
    public String getGitCommitsUrl() {
        return gitCommitsUrl;
    }

    @JsonProperty("git_commits_url")
    public void setGitCommitsUrl(String gitCommitsUrl) {
        this.gitCommitsUrl = gitCommitsUrl;
    }

    @JsonProperty("git_refs_url")
    public String getGitRefsUrl() {
        return gitRefsUrl;
    }

    @JsonProperty("git_refs_url")
    public void setGitRefsUrl(String gitRefsUrl) {
        this.gitRefsUrl = gitRefsUrl;
    }

    @JsonProperty("git_tags_url")
    public String getGitTagsUrl() {
        return gitTagsUrl;
    }

    @JsonProperty("git_tags_url")
    public void setGitTagsUrl(String gitTagsUrl) {
        this.gitTagsUrl = gitTagsUrl;
    }

    @JsonProperty("git_url")
    public String getGitUrl() {
        return gitUrl;
    }

    @JsonProperty("git_url")
    public void setGitUrl(String gitUrl) {
        this.gitUrl = gitUrl;
    }

    @JsonProperty("has_downloads")
    public Boolean getHasDownloads() {
        return hasDownloads;
    }

    @JsonProperty("has_downloads")
    public void setHasDownloads(Boolean hasDownloads) {
        this.hasDownloads = hasDownloads;
    }

    @JsonProperty("has_issues")
    public Boolean getHasIssues() {
        return hasIssues;
    }

    @JsonProperty("has_issues")
    public void setHasIssues(Boolean hasIssues) {
        this.hasIssues = hasIssues;
    }

    @JsonProperty("has_pages")
    public Boolean getHasPages() {
        return hasPages;
    }

    @JsonProperty("has_pages")
    public void setHasPages(Boolean hasPages) {
        this.hasPages = hasPages;
    }

    @JsonProperty("has_projects")
    public Boolean getHasProjects() {
        return hasProjects;
    }

    @JsonProperty("has_projects")
    public void setHasProjects(Boolean hasProjects) {
        this.hasProjects = hasProjects;
    }

    @JsonProperty("has_wiki")
    public Boolean getHasWiki() {
        return hasWiki;
    }

    @JsonProperty("has_wiki")
    public void setHasWiki(Boolean hasWiki) {
        this.hasWiki = hasWiki;
    }

    @JsonProperty("homepage")
    public Object getHomepage() {
        return homepage;
    }

    @JsonProperty("homepage")
    public void setHomepage(Object homepage) {
        this.homepage = homepage;
    }

    @JsonProperty("hooks_url")
    public String getHooksUrl() {
        return hooksUrl;
    }

    @JsonProperty("hooks_url")
    public void setHooksUrl(String hooksUrl) {
        this.hooksUrl = hooksUrl;
    }

    @JsonProperty("html_url")
    public String getHtmlUrl() {
        return htmlUrl;
    }

    @JsonProperty("html_url")
    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("issue_comment_url")
    public String getIssueCommentUrl() {
        return issueCommentUrl;
    }

    @JsonProperty("issue_comment_url")
    public void setIssueCommentUrl(String issueCommentUrl) {
        this.issueCommentUrl = issueCommentUrl;
    }

    @JsonProperty("issue_events_url")
    public String getIssueEventsUrl() {
        return issueEventsUrl;
    }

    @JsonProperty("issue_events_url")
    public void setIssueEventsUrl(String issueEventsUrl) {
        this.issueEventsUrl = issueEventsUrl;
    }

    @JsonProperty("issues_url")
    public String getIssuesUrl() {
        return issuesUrl;
    }

    @JsonProperty("issues_url")
    public void setIssuesUrl(String issuesUrl) {
        this.issuesUrl = issuesUrl;
    }

    @JsonProperty("keys_url")
    public String getKeysUrl() {
        return keysUrl;
    }

    @JsonProperty("keys_url")
    public void setKeysUrl(String keysUrl) {
        this.keysUrl = keysUrl;
    }

    @JsonProperty("labels_url")
    public String getLabelsUrl() {
        return labelsUrl;
    }

    @JsonProperty("labels_url")
    public void setLabelsUrl(String labelsUrl) {
        this.labelsUrl = labelsUrl;
    }

    @JsonProperty("language")
    public String getLanguage() {
        return language;
    }

    @JsonProperty("language")
    public void setLanguage(String language) {
        this.language = language;
    }

    @JsonProperty("languages_url")
    public String getLanguagesUrl() {
        return languagesUrl;
    }

    @JsonProperty("languages_url")
    public void setLanguagesUrl(String languagesUrl) {
        this.languagesUrl = languagesUrl;
    }

    @JsonProperty("merges_url")
    public String getMergesUrl() {
        return mergesUrl;
    }

    @JsonProperty("merges_url")
    public void setMergesUrl(String mergesUrl) {
        this.mergesUrl = mergesUrl;
    }

    @JsonProperty("milestones_url")
    public String getMilestonesUrl() {
        return milestonesUrl;
    }

    @JsonProperty("milestones_url")
    public void setMilestonesUrl(String milestonesUrl) {
        this.milestonesUrl = milestonesUrl;
    }

    @JsonProperty("mirror_url")
    public Object getMirrorUrl() {
        return mirrorUrl;
    }

    @JsonProperty("mirror_url")
    public void setMirrorUrl(Object mirrorUrl) {
        this.mirrorUrl = mirrorUrl;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("notifications_url")
    public String getNotificationsUrl() {
        return notificationsUrl;
    }

    @JsonProperty("notifications_url")
    public void setNotificationsUrl(String notificationsUrl) {
        this.notificationsUrl = notificationsUrl;
    }

    @JsonProperty("open_issues")
    public Integer getOpenIssues() {
        return openIssues;
    }

    @JsonProperty("open_issues")
    public void setOpenIssues(Integer openIssues) {
        this.openIssues = openIssues;
    }

    @JsonProperty("open_issues_count")
    public Integer getOpenIssuesCount() {
        return openIssuesCount;
    }

    @JsonProperty("open_issues_count")
    public void setOpenIssuesCount(Integer openIssuesCount) {
        this.openIssuesCount = openIssuesCount;
    }

    @JsonProperty("owner")
    public Owner getOwner() {
        return owner;
    }

    @JsonProperty("owner")
    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @JsonProperty("private")
    public Boolean getPrivate() {
        return _private;
    }

    @JsonProperty("private")
    public void setPrivate(Boolean _private) {
        this._private = _private;
    }

    @JsonProperty("pulls_url")
    public String getPullsUrl() {
        return pullsUrl;
    }

    @JsonProperty("pulls_url")
    public void setPullsUrl(String pullsUrl) {
        this.pullsUrl = pullsUrl;
    }

    @JsonProperty("pushed_at")
    public String getPushedAt() {
        return pushedAt;
    }

    @JsonProperty("pushed_at")
    public void setPushedAt(String pushedAt) {
        this.pushedAt = pushedAt;
    }

    @JsonProperty("releases_url")
    public String getReleasesUrl() {
        return releasesUrl;
    }

    @JsonProperty("releases_url")
    public void setReleasesUrl(String releasesUrl) {
        this.releasesUrl = releasesUrl;
    }

    @JsonProperty("size")
    public Integer getSize() {
        return size;
    }

    @JsonProperty("size")
    public void setSize(Integer size) {
        this.size = size;
    }

    @JsonProperty("ssh_url")
    public String getSshUrl() {
        return sshUrl;
    }

    @JsonProperty("ssh_url")
    public void setSshUrl(String sshUrl) {
        this.sshUrl = sshUrl;
    }

    @JsonProperty("stargazers_count")
    public Integer getStargazersCount() {
        return stargazersCount;
    }

    @JsonProperty("stargazers_count")
    public void setStargazersCount(Integer stargazersCount) {
        this.stargazersCount = stargazersCount;
    }

    @JsonProperty("stargazers_url")
    public String getStargazersUrl() {
        return stargazersUrl;
    }

    @JsonProperty("stargazers_url")
    public void setStargazersUrl(String stargazersUrl) {
        this.stargazersUrl = stargazersUrl;
    }

    @JsonProperty("statuses_url")
    public String getStatusesUrl() {
        return statusesUrl;
    }

    @JsonProperty("statuses_url")
    public void setStatusesUrl(String statusesUrl) {
        this.statusesUrl = statusesUrl;
    }

    @JsonProperty("subscribers_url")
    public String getSubscribersUrl() {
        return subscribersUrl;
    }

    @JsonProperty("subscribers_url")
    public void setSubscribersUrl(String subscribersUrl) {
        this.subscribersUrl = subscribersUrl;
    }

    @JsonProperty("subscription_url")
    public String getSubscriptionUrl() {
        return subscriptionUrl;
    }

    @JsonProperty("subscription_url")
    public void setSubscriptionUrl(String subscriptionUrl) {
        this.subscriptionUrl = subscriptionUrl;
    }

    @JsonProperty("svn_url")
    public String getSvnUrl() {
        return svnUrl;
    }

    @JsonProperty("svn_url")
    public void setSvnUrl(String svnUrl) {
        this.svnUrl = svnUrl;
    }

    @JsonProperty("tags_url")
    public String getTagsUrl() {
        return tagsUrl;
    }

    @JsonProperty("tags_url")
    public void setTagsUrl(String tagsUrl) {
        this.tagsUrl = tagsUrl;
    }

    @JsonProperty("teams_url")
    public String getTeamsUrl() {
        return teamsUrl;
    }

    @JsonProperty("teams_url")
    public void setTeamsUrl(String teamsUrl) {
        this.teamsUrl = teamsUrl;
    }

    @JsonProperty("trees_url")
    public String getTreesUrl() {
        return treesUrl;
    }

    @JsonProperty("trees_url")
    public void setTreesUrl(String treesUrl) {
        this.treesUrl = treesUrl;
    }

    @JsonProperty("updated_at")
    public String getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty("updated_at")
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("watchers")
    public Integer getWatchers() {
        return watchers;
    }

    @JsonProperty("watchers")
    public void setWatchers(Integer watchers) {
        this.watchers = watchers;
    }

    @JsonProperty("watchers_count")
    public Integer getWatchersCount() {
        return watchersCount;
    }

    @JsonProperty("watchers_count")
    public void setWatchersCount(Integer watchersCount) {
        this.watchersCount = watchersCount;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(archiveUrl).append(assigneesUrl).append(blobsUrl).append(branchesUrl).append(cloneUrl).append(collaboratorsUrl).append(commentsUrl).append(commitsUrl).append(compareUrl).append(contentsUrl).append(contributorsUrl).append(createdAt).append(defaultBranch).append(deploymentsUrl).append(description).append(downloadsUrl).append(eventsUrl).append(fork).append(forks).append(forksCount).append(forksUrl).append(fullName).append(gitCommitsUrl).append(gitRefsUrl).append(gitTagsUrl).append(gitUrl).append(hasDownloads).append(hasIssues).append(hasPages).append(hasProjects).append(hasWiki).append(homepage).append(hooksUrl).append(htmlUrl).append(id).append(issueCommentUrl).append(issueEventsUrl).append(issuesUrl).append(keysUrl).append(labelsUrl).append(language).append(languagesUrl).append(mergesUrl).append(milestonesUrl).append(mirrorUrl).append(name).append(notificationsUrl).append(openIssues).append(openIssuesCount).append(owner).append(_private).append(pullsUrl).append(pushedAt).append(releasesUrl).append(size).append(sshUrl).append(stargazersCount).append(stargazersUrl).append(statusesUrl).append(subscribersUrl).append(subscriptionUrl).append(svnUrl).append(tagsUrl).append(teamsUrl).append(treesUrl).append(updatedAt).append(url).append(watchers).append(watchersCount).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Repo) == false) {
            return false;
        }
        Repo rhs = ((Repo) other);
        return new EqualsBuilder().append(archiveUrl, rhs.archiveUrl).append(assigneesUrl, rhs.assigneesUrl).append(blobsUrl, rhs.blobsUrl).append(branchesUrl, rhs.branchesUrl).append(cloneUrl, rhs.cloneUrl).append(collaboratorsUrl, rhs.collaboratorsUrl).append(commentsUrl, rhs.commentsUrl).append(commitsUrl, rhs.commitsUrl).append(compareUrl, rhs.compareUrl).append(contentsUrl, rhs.contentsUrl).append(contributorsUrl, rhs.contributorsUrl).append(createdAt, rhs.createdAt).append(defaultBranch, rhs.defaultBranch).append(deploymentsUrl, rhs.deploymentsUrl).append(description, rhs.description).append(downloadsUrl, rhs.downloadsUrl).append(eventsUrl, rhs.eventsUrl).append(fork, rhs.fork).append(forks, rhs.forks).append(forksCount, rhs.forksCount).append(forksUrl, rhs.forksUrl).append(fullName, rhs.fullName).append(gitCommitsUrl, rhs.gitCommitsUrl).append(gitRefsUrl, rhs.gitRefsUrl).append(gitTagsUrl, rhs.gitTagsUrl).append(gitUrl, rhs.gitUrl).append(hasDownloads, rhs.hasDownloads).append(hasIssues, rhs.hasIssues).append(hasPages, rhs.hasPages).append(hasProjects, rhs.hasProjects).append(hasWiki, rhs.hasWiki).append(homepage, rhs.homepage).append(hooksUrl, rhs.hooksUrl).append(htmlUrl, rhs.htmlUrl).append(id, rhs.id).append(issueCommentUrl, rhs.issueCommentUrl).append(issueEventsUrl, rhs.issueEventsUrl).append(issuesUrl, rhs.issuesUrl).append(keysUrl, rhs.keysUrl).append(labelsUrl, rhs.labelsUrl).append(language, rhs.language).append(languagesUrl, rhs.languagesUrl).append(mergesUrl, rhs.mergesUrl).append(milestonesUrl, rhs.milestonesUrl).append(mirrorUrl, rhs.mirrorUrl).append(name, rhs.name).append(notificationsUrl, rhs.notificationsUrl).append(openIssues, rhs.openIssues).append(openIssuesCount, rhs.openIssuesCount).append(owner, rhs.owner).append(_private, rhs._private).append(pullsUrl, rhs.pullsUrl).append(pushedAt, rhs.pushedAt).append(releasesUrl, rhs.releasesUrl).append(size, rhs.size).append(sshUrl, rhs.sshUrl).append(stargazersCount, rhs.stargazersCount).append(stargazersUrl, rhs.stargazersUrl).append(statusesUrl, rhs.statusesUrl).append(subscribersUrl, rhs.subscribersUrl).append(subscriptionUrl, rhs.subscriptionUrl).append(svnUrl, rhs.svnUrl).append(tagsUrl, rhs.tagsUrl).append(teamsUrl, rhs.teamsUrl).append(treesUrl, rhs.treesUrl).append(updatedAt, rhs.updatedAt).append(url, rhs.url).append(watchers, rhs.watchers).append(watchersCount, rhs.watchersCount).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
