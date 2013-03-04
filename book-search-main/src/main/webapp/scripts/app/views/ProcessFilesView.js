define(["ember", "text!templates/processFilesTemplate.handlebars"], function(Ember, processFiles) {
	var ProcessFilesView = Ember.View.extend({
		tagName: "div",
		classNames: ["ProcessFiles"],
        defaultTemplate: Ember.Handlebars.compile(processFiles)

	});
	return ProcessFilesView;
});