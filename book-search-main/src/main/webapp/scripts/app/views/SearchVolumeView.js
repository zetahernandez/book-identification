define(["ember"], function(Ember) {
	var SearchVolumeView = Ember.TextField.extend(Ember.TargetActionSupport, {
		valueBinding: 'controller.searchText',
		classNames: ["searchInput", "span6"],
		insertNewline: function() {
			this.get("controller").searchVolumes();
		}
	});
	return SearchVolumeView;
});