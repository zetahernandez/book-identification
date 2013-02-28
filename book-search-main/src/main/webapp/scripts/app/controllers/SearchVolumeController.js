define(["require", "ember"], function () {
	var SearchVolumeController = Ember.ObjectController.extend({
		needs : ['volumeList'],
		searchText: '',

		searchVolumes: function () {
			this.get('controllers.volumeList').searchVolumes(this.get('searchText'));
		}

	});
	return SearchVolumeController;
});