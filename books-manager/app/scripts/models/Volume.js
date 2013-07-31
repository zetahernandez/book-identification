BooksManager.Volume = DS.Model.extend({
  bookId: DS.attr('string'),
  kind: DS.attr('string'),
  path: DS.attr('string'),
  volumeInfo: DS.belongsTo('BooksManager.VolumeInfo')
});