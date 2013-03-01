define(["ember"], function (Ember) {
	var Router = function () {

		this.resource('categories');

		this.route("volumes", {
			path: "/volumes"
		});
		this.route("volumeInfoDetail", {
			path: "/volumes/:volume_id"
		});
		this.route("uploadBooks", {
			path: "/uploadBook"
		});
	};
	return Router;
});