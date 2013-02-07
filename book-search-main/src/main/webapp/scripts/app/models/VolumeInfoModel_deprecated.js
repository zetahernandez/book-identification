define(
["require", "ember", "jquery"], function (require, Ember, $) {
	var VolumeInfoModel = Ember.Object.extend({

		title: null,
		subtitle: null,
		description: null,
		language: null,
		pageCount: null,
		publishedDate: null,
		publisher: null,

		unescapedDescription: function () {
			return this.get('description').htmlSafe();
		}.property('html'),

		init: function () {
			this._super();
			volumeInfoListController = require("controllers/VolumeInfoListController");
		},

		allVolumeInfo: [],
		find: function () {
			$.ajax({
				url: 'rest/volumeinfo',
				dataType: 'json',
				context: this,
				success: function (response) {
					this.allVolumeInfo.addObjects(response.map(function (raw) {
						return VolumeInfoModel.create(raw);
					}));
				}
			});
			return this.allVolumeInfo;
		}

	});

	return VolumeInfoModel;
});