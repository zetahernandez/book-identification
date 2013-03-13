define(["ember", "models/FileToUpload"], function(Ember, FileToUpload) {
	var UploadBooksController = Ember.ObjectController.extend({
		dropText: 'Drop Here',
		files: [],
		ignoredFiles: [],

		processFiles: function(files) {
			_self = this;
			jQuery.each(files, function(index, file) {
				if (file.type === "application/pdf") {
					_self.get('files').pushObject(FileToUpload.create({
						index: index,
						file: file
					}));
				} else {
					_self.get('ignoredFiles').pushObject(FileToUpload.create({
						index: index,
						file: file
					}));
				}
			});
		},

		uploadToServer: function() {
			jQuery.each(this.get('files'), function(index, file) {
				file.uploadToServer();
			});
			var uploaded = jQuery.grep(this.get('files'), function(file) {
				return file.isUploaded();
			});
			this.analizeAndSupervise(uploaded);
		},

		clearListFile: function() {
			this.set('files', []);
		},

		analizeAndSupervise: function(files) {
			var uploadedFiles = [];
			jQuery.each(files, function(index, file) {
				filesJson.pushObject({
					index: file.index,
					fileName: file.file.fileName
				});
			});
			var socket = $.atmosphere;
			var request = new $.atmosphere.AtmosphereRequest();
			request.url = "rest/volumes/chat";
			request.contentType = "application/json";
			var subSocket = socket.subscribe(request);

			subSocket.push(JSON.stringify(uploadedFiles));
		}


	});

	return UploadBooksController;
});