define(
["ember", "atmosphere"], function (Ember) {
	var FileToUpload = Ember.Object.extend({
		index: null,
		file: null,
		identified: false,
		uploaded: 0,

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
		}.property('file.size'),

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

		isUploaded: function () {
			return this.get('uploaded') == 100;
		}.property('uploaded'),

		uploadToServer: function () {

			var formData = new FormData(),
				_self = this;

			formData.append('fileName', this.get('name'));
			formData.append('file', this.get('file'));

			var xhr = new XMLHttpRequest();
			xhr.open('POST', '/rest/volumes/upload', true);
			xhr.upload.onprogress = function (event) {
				if (event.lengthComputable) {
					_self.set('uploaded', Math.round((event.loaded / event.total) * 100));
				}
			};
			xhr.onload = function (event) {
				_self.set('uploaded', 100);
				var socket = $.atmosphere;
				var request = new $.atmosphere.AtmosphereRequest();
				request.url = "rest/volumes/chat";
				request.contentType = "application/json";
				request.transport = 'long-polling';
				request.fallbackTransport = 'long-polling';
				var subSocket = socket.subscribe(request);
				subSocket.push(JSON.stringify({hole:'hola'}));
			};
			xhr.send(formData);
		}
	});

	return FileToUpload;
});