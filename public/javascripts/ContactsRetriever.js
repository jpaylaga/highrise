var ContactsRetriever = {

  'retrievePageUrl'     : (typeof retrievePageUrl === 'string')      ? retrievePageUrl      : false,
  'displayPageUrl'      : (typeof displayPageUrl === 'string')       ? displayPageUrl       : false,
  'loadContactsUrl'     : (typeof loadContactsUrl === 'string')      ? loadContactsUrl      : false,
  'loadContactsByTagUrl': (typeof loadContactsByTagUrl === 'string') ? loadContactsByTagUrl : false,

  'loadContacts': function(cb, errorCb) {
    this.postCall(this.loadContactsUrl, {}, cb);
  },

  'loadContactsByTag': function(tag, cb, errorCb) {
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
