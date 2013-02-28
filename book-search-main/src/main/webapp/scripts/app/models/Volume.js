define(["ember", "ember_data"], function (Ember, DS) {
	var Volume = DS.Model.extend({
		bookId: DS.attr('string'),
		kind: DS.attr('string'),
		path: DS.attr('string'),
		volumeInfo: DS.belongsTo('BooksApp.VolumeInfo')
	});
	return Volume;
});