define([ "ember", "text!templates/applicationTemplate.handlebars" ], function(
		Ember, applicationTemplate) {
	var SearchVolumeView = Ember.TextField.extend(Ember.TargetActionSupport, {
		valueBinding : 'BooksApp.searchController.searchTexts',
		classNames: ["searchInput"],
		insertNewline : function() {
			this.triggerAction();
		}
	});
	return SearchVolumeView;
});