package com.zaidanpratama.staysafeurl


import com.google.gson.annotations.SerializedName

data class PhisingResponseItem(
    @SerializedName("abuse_ch_malware")
    val abuseChMalware: Any,
    @SerializedName("abuse_contact")
    val abuseContact: Any,
    @SerializedName("alexa_rank_domain")
    val alexaRankDomain: Any,
    @SerializedName("alexa_rank_host")
    val alexaRankHost: Any,
    @SerializedName("asn")
    val asn: String,
    @SerializedName("bgp")
    val bgp: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("countrycode")
    val countrycode: String,
    @SerializedName("countryname")
    val countryname: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("date_update")
    val dateUpdate: String,
    @SerializedName("domain")
    val domain: Any,
    @SerializedName("domain_registered_n_days_ago")
    val domainRegisteredNDaysAgo: Any,
    @SerializedName("google_safebrowsing")
    val googleSafebrowsing: Any,
    @SerializedName("hash")
    val hash: String,
    @SerializedName("host")
    val host: Any,
    @SerializedName("http_code")
    val httpCode: Any,
    @SerializedName("http_server")
    val httpServer: Any,
    @SerializedName("id")
    val id: Int,
    @SerializedName("ip")
    val ip: String,
    @SerializedName("isp")
    val isp: String,
    @SerializedName("latitude")
    val latitude: String,
    @SerializedName("longitude")
    val longitude: String,
    @SerializedName("n_times_seen_domain")
    val nTimesSeenDomain: Any,
    @SerializedName("n_times_seen_host")
    val nTimesSeenHost: Any,
    @SerializedName("n_times_seen_ip")
    val nTimesSeenIp: Any,
    @SerializedName("os")
    val os: Any,
    @SerializedName("page_text")
    val pageText: Any,
    @SerializedName("ports")
    val ports: Any,
    @SerializedName("regioncode")
    val regioncode: String,
    @SerializedName("regionname")
    val regionname: String,
    @SerializedName("score")
    val score: Any,
    @SerializedName("screenshot")
    val screenshot: Any,
    @SerializedName("ssl_issuer")
    val sslIssuer: Any,
    @SerializedName("ssl_subject")
    val sslSubject: Any,
    @SerializedName("tags")
    val tags: Any,
    @SerializedName("technology")
    val technology: Any,
    @SerializedName("threat_crowd")
    val threatCrowd: Any,
    @SerializedName("threat_crowd_subdomain_count")
    val threatCrowdSubdomainCount: Any,
    @SerializedName("threat_crowd_votes")
    val threatCrowdVotes: Any,
    @SerializedName("title")
    val title: String,
    @SerializedName("tld")
    val tld: Any,
    @SerializedName("url")
    val url: String,
    @SerializedName("virus_total")
    val virusTotal: Any,
    @SerializedName("vulns")
    val vulns: Any,
    @SerializedName("zipcode")
    val zipcode: String
)