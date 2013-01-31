define([ "ember", "text!templates/volumeInfoListTemplate.handlebars" ],
		function(Ember, volumesTemplate) {
			var VolumeListView = Ember.View.extend({
				classNames: ["searchInput"],
			  template : Ember.Handlebars.compile(volumesTemplate),
				
				init : function() {
					this._super();
					console.log("init");
					Ember.run.later(this, "addInfiniteScroll", 2000);
				},
				willDestroyElement : function() {
					BooksApp.router.volumeListController.page = 0;
					this._super();
				},
				
				addInfiniteScroll : function() {
					$("#infiniteScroll").endlessScroll(
							{
								loader : '<div class="loading"><div>',
								ceaseFireOnEmpty : false,

								content : function(fireSequence, pageSequence,
										scrollDirection) {
									return " ";
								},
								callback : function(fireSequence, pageSequence,	scrollDirection) {
									if (scrollDirection == "next") {
										BooksApp.router.volumeListController.addMoreVolumes(BooksApp.router.volumeListController.get("page") + 1);
									}
								}
							});
				}
			});
			return VolumeListView;
		});
