define(["ember", "text!templates/uploadBooksTemplate.handlebars"], function(Ember, uploadBooksTemplate) {
	var UploadBooksView = Ember.View.extend({
		defaultTemplate: Ember.Handlebars.compile(uploadBooksTemplate),
		classNames: ["span10" ,"uploadBooks"]

	});
	return UploadBooksView;
});