var ContactsRetriever = {

  'loadContactsUrl'     : (typeof loadContactsUrl === 'string') ? loadContactsUrl : '',
  'loadContactsByTagUrl': (typeof loadContactsByTagUrl === 'string') ? loadContactsByTagUrl : '',

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
  }
};
