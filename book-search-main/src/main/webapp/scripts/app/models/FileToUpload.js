define(["ember", "jquery", "atmosphere"], function (Ember, jQuery) {
  var FileToUpload = Ember.Object.extend({
    index: null,
    file: null,
    identified: false,
    uploaded: 0,

    /*
        return file.name value 
    */
    name: function () {
      return this.get('file.name');
    }.property('file.name'),

    /*
      Convert and return  file.size bytes size value on meagabytes
    */
    size: function () {
      var result,
      bytes = this.get('file.size'),
        precision = 2,
        kilobyte = 1024,
        megabyte = kilobyte * 1024,
        gigabyte = megabyte * 1024,
        terabyte = gigabyte * 1024;

      if ((bytes >= 0) && (bytes < kilobyte)) {
        result = bytes + ' B';

      } else if ((bytes >= kilobyte) && (bytes < megabyte)) {
        result = (bytes / kilobyte).toFixed(precision) + ' KB';

      } else if ((bytes >= megabyte) && (bytes < gigabyte)) {
        result = (bytes / megabyte).toFixed(precision) + ' MB';

      } else if ((bytes >= gigabyte) && (bytes < terabyte)) {
        result = (bytes / gigabyte).toFixed(precision) + ' GB';

      } else if (bytes >= terabyte) {
        result = (bytes / terabyte).toFixed(precision) + ' TB';

      } else {
        result = bytes + ' B';
      }
      return result;
    }.property('file.size'),

    //read file UNUSED
    readMe: function () {
      var reader = new FileReader(),
        _self = this;

      reader.onload = function (event) {
        _self.set('file.data', event.target.result);
        _self.set('uploaded', 100);
      };

      reader.onprogress = function (event) {
        if (event.lengthComputable) {
          _self.set('uploaded', Math.round((event.loaded / event.total) * 100));
        }
      };
      reader.readAsDataURL(this.get('file'));
    },

    isUploadComplete: function () {
      return this.get('uploaded') === 100;
    }.property('uploaded'),


  });

  return FileToUpload;
});