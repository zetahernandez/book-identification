define(
["ember"], function (Ember) {
	var FileToUpload = Ember.Object.extend({
		order:null,
		file: null,
		identified: false,

		name: function () {
			return this.get('file.name');
		}.property('file.name'),

		size: function () {
			var bytes = this.get('file.size'),
				precision = 2,
				kilobyte = 1024,
				megabyte = kilobyte * 1024,
				gigabyte = megabyte * 1024,
				terabyte = gigabyte * 1024;

			if ((bytes >= 0) && (bytes < kilobyte)) {
				return bytes + ' B';

			} else if ((bytes >= kilobyte) && (bytes < megabyte)) {
				return (bytes / kilobyte).toFixed(precision) + ' KB';

			} else if ((bytes >= megabyte) && (bytes < gigabyte)) {
				return (bytes / megabyte).toFixed(precision) + ' MB';

			} else if ((bytes >= gigabyte) && (bytes < terabyte)) {
				return (bytes / gigabyte).toFixed(precision) + ' GB';

			} else if (bytes >= terabyte) {
				return (bytes / terabyte).toFixed(precision) + ' TB';

			} else {
				return bytes + ' B';
			}
		}.property('file.size')
	});

	return FileToUpload;
});