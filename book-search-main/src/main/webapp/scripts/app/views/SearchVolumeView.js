define(["ember"], function (Ember) {
	var SearchVolumeView = Ember.TextField.extend(Ember.TargetActionSupport, {
		valueBinding: 'BooksApp.router.searchVolumeController.searchText',
		//		controller : 'BooksApp.SearchVolumeController',
		classNames: ["searchInput"],

		insertNewline: function () {
			this.get("controller").searchVolumes();
		}
	});
	return SearchVolumeView;
});