define(
		[ "require", "ember", "controllers/VolumeInfoListController" ],
		function(require, Ember, volumeInfoListController) {
			var VolumeInfo = Ember.Object.extend({
				entityId : null,
				title : null,
				subtitle : null,
				description : null,
				language : null,
				pageCount : null,
				publishedDate : null,
				publisher : null,

				init : function() {
					this._super();
					volumeInfoListController = require("controllers/VolumeInfoListController");
				},

				allVolumeInfo : [],
				find : function() {
					$.ajax({
						url : '/volumeinfo',
						dataType : 'jsonp',
						context : this,
						success : function(response) {
							this.allVolumeInfo.addObjects(response.data
									.map(function(raw) {
										return App.Volumeinfo.create(raw);
									}));
						}
					});
					return this.allVolumeInfo;
				}

			});

			return VolumeInfo;
			});