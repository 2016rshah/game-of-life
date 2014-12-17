// var express = require('express.io')
// var app = express()

// app.get('/', function (req, res) {
//   res.send('Hello World!')
// })

// var server = app.listen(3000, function () {

//   var host = server.address().address
//   var port = server.address().port

//   console.log('Example app listening at http://%s:%s', host, port)

// })





var GitHubApi = require("github");
var isodate = require("isodate");
var fs = require('fs')
var TOKEN = ""
var path = __dirname + "/private/secrets.txt"
fs.readFile(path, 'utf8', function(err, data){
    TOKEN = data.split("\n")[0]
    var datesContributed = []
    // // Read a date string
    // var date = isodate("2011-08-20T19:39:52Z");
    // console.log(date);


    var github = new GitHubApi({
        // required
        version: "3.0.0",
    });
    github.authenticate({
        type: "oauth", 
        token: TOKEN
    })
    github.repos.getAll({
        // optional:
        // headers: {
        //     "cookie": "blahblah"
        // },
        user: "2016rshah",
        type: "public"
    }, function(err, res) {
        if(err)
            console.log(err);
        var data = res
        for(var i = 0; i<data.length; i++)
        {
            github.repos.getCommits({
                user: "2016rshah", 
                repo: data[i].name
            }, function(err, result){
                if(err)
                    console.log(err)
                else
                {
                    var commits = result
                    for(var i = 0; i<commits.length; i++)
                    {
                        //console.log(commits[i].commit)
                        console.log(isodate(commits[i].commit.committer.date))
                        datesContributed.push(isodate(commits[i].commit.committer.date))
                    }
                }
            })
        }
    });
})
