var ContactsRetriever = {

  'retrievePageUrl'                 : (typeof retrievePageUrl === 'string') ? retrievePageUrl : false,
  'displayPageUrl'                  : (typeof displayPageUrl === 'string') ? displayPageUrl : false,
  'loadContactsByTagUrl'            : (typeof loadContactsByTagUrl === 'string') ? loadContactsByTagUrl : false,
  'loadContactsFromDatabaseUrl'     : (typeof loadContactsFromDatabaseUrl === 'string') ? loadContactsFromDatabaseUrl : false,
  'loadContactsFromDatabaseByTagUrl': (typeof loadContactsFromDatabaseByTagUrl === 'string') ? loadContactsFromDatabaseByTagUrl : false,

  'loadContactsFromDatabase': function(cb) {
    this.postCall(this.loadContactsFromDatabaseUrl, {}, cb);
  },

  'loadContactsFromDatabaseByTag': function(tag, cb) {
    this.postCall(this.loadContactsFromDatabaseByTagUrl, {"tag": tag}, cb);
  },

  'loadContactsByTag': function(tag, cb) {
    this.postCall(this.loadContactsByTagUrl, {"tag": tag}, cb);
  },

  'postCall': function(url, params, cb) {
    $.post(url, params, function( data ) {
      if (typeof cb == 'function') {
        cb( data );
      }
    }, "json");
  },

  'redirectToDisplayPage': function(delay) {
    if (this.displayPageUrl) {
      setTimeout(function() {
        window.location.href = this.displayPageUrl;
      }, (delay) ? delay : 0);
    }
  }
};
