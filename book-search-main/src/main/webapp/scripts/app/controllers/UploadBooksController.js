define(["ember","models/FileToUpload"], function(Ember,FileToUpload) {
	var UploadBooksController = Ember.ObjectController.extend({
		dropText: 'Drop Here',
		files: [],

		processFiles: function(files) {
			for (var i = files.length - 1; i >= 0; i--) {
				tempFile = files[i];
				if(tempFile.type === "application/pdf"){
					this.get('files').pushObject(FileToUpload.create({file:tempFile}));
				}
			}
		}
	});

	return UploadBooksController;
});