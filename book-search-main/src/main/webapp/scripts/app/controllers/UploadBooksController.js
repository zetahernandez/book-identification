define(["ember","models/FileToUpload"], function(Ember,FileToUpload) {
	var UploadBooksController = Ember.ObjectController.extend({
		dropText: 'Drop Here',
		files: [],

		processFiles: function(files) {
			for (var i = 0;  i < files.length; i++) {
				tempFile = files[i];
				if(tempFile.type === "application/pdf"){
					this.get('files').pushObject(FileToUpload.create({order:i, file:tempFile}));
				}
			}
		},
		clearListFile: function() {
			this.set('files',[]);
		}
	});

	return UploadBooksController;
});