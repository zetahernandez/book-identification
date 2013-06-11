define(
["require", "ember", "jquery", "controllers/VolumeController"], function (require, Ember, $, volumeController) {
	var VolumeModel = Ember.Object.extend({
		entityId: null,
		id: null,
		path: null,
		volumeInfo: Ember.ArrayProxy.create(),

		init: function () {
			this._super();
			volumeInfoListController = require("controllers/VolumeController");
		},

		allVolume: [],
		find: function () {
			$.ajax({
				url: 'rest/volume',
				dataType: 'json',
				context: this,
				success: function (response) {
					this.allVolume.addObjects(response.map(function (raw) {
						return this.VolumeModel.create(raw);
					}));
				}
			});
			return this.allVolume;
		}

	});

	return VolumeModel;
});