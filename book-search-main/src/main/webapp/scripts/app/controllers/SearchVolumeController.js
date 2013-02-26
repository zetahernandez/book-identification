define(["require", "ember"], function () {
	var SearchVolumeController = Ember.ObjectController.extend({
		needs : ['volumeList'],
		searchText: '',

		searchVolumes: function () {
			this.get('controllers.volumeListController').searchVolumes(this.get('searchText'));
		}

	});
	return SearchVolumeController;
});