module.exports = function (mongoose) {

  var Schema = mongoose.Schema,
    ObjectId = mongoose.Schema;

  var VolumeSchema = new Schema({
    kind: String,
    id: ObjectId,
    etag: String,
    selfLink: String,
    volumeInfo: {
      title: String,
      authors: [String],
      publisher: String,
      publishedDate: Number,
      description: String,
      industryIdentifiers: [{
        type: String,
        identifier: String
      }],
      pageCount: Number,
      dimensions: {
        height: String
      },
      printType: String,
      categories: [String],
      averageRating: Number,
      ratingsCount: Number,
      contentVersion: String,
      imageLinks: {
        smallThumbnail: String,
        thumbnail: String
      },
      language: String,
      previewLink: String,
      infoLink: String,
      canonicalVolumeLink: String
    },
    saleInfo: {
      country: String,
      saleability: String,
      isEbook: Boolean
    },
    accessInfo: {
      country: String,
      viewability: String,
      embeddable: Boolean,
      publicDomain: Boolean,
      textToSpeechPermission: String,
      epub: {
        isAvailable: Boolean
      },
      pdf: {
        isAvailable: Boolean
      },
      webReaderLink: String,
      accessViewStatus: String
    },
    searchInfo: {
      textSnippet: String
    }
  });

  var addVolume = function (volume, callback) {
    volume = new VolumeSchema(volume);
    volume.save();
  };

  var Volume = mongoose.model('Volume', VolumeSchema);

  return {
    addVolume: addVolume,
    Volume: Volume
  };
};