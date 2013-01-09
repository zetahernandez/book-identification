define(
		[ "require", "ember", "jquery", "controllers/VolumeInfoListController" ],
		function(require, Ember, $, volumeInfoListController) {
			var VolumeInfoModel = Ember.Object
					.extend({
						unescapedDescription: function() {
							return this.get('description').htmlSafe();
						}.property('html'),

						init : function() {
							this._super();
							volumeInfoListController = require("controllers/VolumeInfoListController");
						},

						allVolumeInfo : [],
						find : function() {
							$.ajax({
								url : 'rest/volumeinfo',
								dataType : 'json',
								context : this,
								success : function(response) {
									this.allVolumeInfo.addObjects(response
											.map(function(raw) {
												return VolumeInfoModel
														.create(raw);
											}));
								}
							});
							return this.allVolumeInfo;
						}

					});

			return VolumeInfoModel;
		});