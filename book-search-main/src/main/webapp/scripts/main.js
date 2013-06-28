(function (root) {
	require(["config"], function (config) {
		requirejs.config(config);
		require(["App", "domReady!", "ember", "ember_data", "inview", "bootstrap", "modernizr"], function (App, doc, Ember, DS, inview, bootsrap, modernizr) {
			var app_name = config.app_name || "App";
			root[app_name] = App;
		});
	});
})(this);