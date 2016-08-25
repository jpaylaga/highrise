function disableForm() {
  $("#tag").prop("disabled", true);
  $("#tag-submit-btn").prop("disabled", true);
  $(".alert").addClass("hidden");
}

function enableForm() {
  $("#tag").prop("disabled", false);
  $("#tag-submit-btn").prop("disabled", false);
}

$(document).ready(function() {
  $("#tag-form").submit(function(e) {
    e.preventDefault();

    var tagname = $("#tag").val();
    disableForm();
    if (typeof targetUrl == "string") {
      disableForm();
      $.post(targetUrl, { "tag": tagname }, function( data ) {
        enableForm();
        if (typeof data.contacts != "undefined") {
          if (data.contacts.length > 0) {
            $(".alert-success").removeClass("hidden");
            $("#tag-success").html(data.contacts.length);
          } else {
            $(".alert-danger").removeClass("hidden");
            $("#tag-error").html("There are no contacts on tag \"" + tagname + "\".");
          }
        } else {
          $(".alert-danger").removeClass("hidden");
          $("#tag-error").html(data.error);
        }
      }, "json");
    }
  });
});
