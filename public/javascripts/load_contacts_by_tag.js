function nullString(str) {
  return (str == null) ? "None" : str;
}

$(document).ready(function() {
  $("#tag-form").submit(function(e) {
    e.preventDefault();

    var tagname = $("#tag").val();
    if (typeof targetUrl == "string") {
      $.post(targetUrl, { "tag": tagname }, function( data ) {
        var tableHTML = "";
        for (var c in data.contacts) {
          tableHTML += "<tr>";
          tableHTML += "<td>" + nullString(data.contacts[c].firstName) + "</td>";
          tableHTML += "<td>" + nullString(data.contacts[c].lastName) + "</td>";
          tableHTML += "<td>" + nullString(data.contacts[c].title) + "</td>";
          tableHTML += "<td>" + nullString(data.contacts[c].companyName) + "</td>";
          tableHTML += "<td>" + nullString(data.contacts[c].background) + "</td>";
          tableHTML += "<td>" + ((data.contacts[c].linkedinUrl) ? '<a href="' + data.contacts[c].linkedinUrl + '" target="_blank">Click here</a>' : "None") + "</td>";
          tableHTML += "<td>" + ((data.contacts[c].instantMessengerProtocol) ? data.contacts[c].instantMessengerAddress + "(" + data.contacts[c].instantMessengerProtocol + ")" : "None" ) + "</td>";
          tableHTML += "<td>" + ((data.contacts[c].emailAddress) ? '<a href="mailto:' + data.contacts[c].emailAddress + '">' + data.contacts[c].emailAddress + '</a>' : "None") + "</td>";
          tableHTML += "<td>" + ((data.contacts[c].twitterAccount) ? '<a href="https://twitter.com/' + data.contacts[c].twitterAccount + '" target="_blank">' + data.contacts[c].twitterAccount + '</a>' : "None") + "</td>";
          tableHTML += "<td>" + nullString(data.contacts[c].address) + "</td>";
          tableHTML += "<td>" + ((data.contacts[c].webAddress) ? '<a href="' + data.contacts[c].webAddress + '" target="_blank">' + data.contacts[c].webAddress + '</a>' : "None") + "</td>";
          tableHTML += "</tr>";
        }
        $("#tag-results").html(tableHTML);
      }, "json");
    }
  });
});
