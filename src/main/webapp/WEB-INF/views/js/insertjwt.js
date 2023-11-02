let pagemove = function(link){
    let httpmsg = {
        method : "GET",
        headers : {
            "Content-Type" : "application/json",
            "jwt-auth-token" : localStorage.getItem("jwt_Access"),
            "jwt-ref-token" : localStorage.getItem("jwt_Refresh"),
        },
    }
    fetch("${root}/" + link, httpmsg);
}