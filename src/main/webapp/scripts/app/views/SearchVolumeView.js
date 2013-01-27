define([ "ember", "text!templates/applicationTemplate.handlebars" ], function(
		Ember, applicationTemplate) {
	var SearchVolumeView = Ember.TextField.extend(Ember.TargetActionSupport, {
//		valueBinding : 'BooksApp.SearchController.searchText',
//		controller : 'BooksApp.SearchController',
		classNames: ["searchInput"],
	
		insertNewline : function() {
			this.triggerAction();
		},
	
	});
	return SearchVolumeView;
});