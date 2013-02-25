define(["require", "ember", "ember_data"], function (require, Ember) {
	var Volume = DS.Model.extend({
		primaryKey: 'id',
		bookId: DS.attr('string'),
		kind: DS.attr('string'),
		path: DS.attr('string'),
		volumeInfo: DS.belongsTo('BooksApp.VolumeInfo', {
			embedded: true
		}),
		//Transient
		page: DS.attr('number'),
		q: DS.attr('string')

	});
	return Volume;
});