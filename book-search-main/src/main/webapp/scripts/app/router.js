define(["ember"], function (Ember) {
	var Router = function () {
		this.resource('categories');
		this.route("volumes", {
			path: "/volumes"
		});
		this.route("volumeInfoDetail", {
			path: "/volumes/:volume_id"
		});
	};
	return Router;
});