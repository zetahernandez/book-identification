define(["ember", "text!templates/applicationTemplate.handlebars"], function (
Ember, applicationTemplate) {
	var SearchVolumeView = Ember.TextField.extend(Ember.TargetActionSupport, {
		valueBinding: 'BooksApp.router.searchVolumeController.searchText',
		//		controller : 'BooksApp.SearchVolumeController',
		classNames: ["searchInput"],

		insertNewline: function () {
			BooksApp.router.get("searchVolumeController").searchVolumes();
		}
	});
	return SearchVolumeView;
});