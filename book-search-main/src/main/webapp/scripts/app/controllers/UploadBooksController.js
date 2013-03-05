define(["ember", "models/FileToUpload"], function (Ember, FileToUpload) {
	var UploadBooksController = Ember.ObjectController.extend({
		dropText: 'Drop Here',
		files: [],
		ignoredFiles: [],

		processFiles: function (files) {
			_self = this;
			jQuery.each(files, function (index, file) {
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

		uploadToServer: function () {
			jQuery.each(this.get('files'), function (index, file) {
				file.uploadToServer();
			});
		},

		clearListFile: function () {
			this.set('files', []);
		}
	});

	return UploadBooksController;
});