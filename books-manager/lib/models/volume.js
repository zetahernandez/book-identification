module.exports = function (mongoose) {

  var Schema = mongoose.Schema,
    ObjectId = Schema.ObjectId;

  var VolumeSchema = new Schema({
    kind: String,
    _id: ObjectId,
    id: String,
    etag: String,
    selfLink: String,
    volumeInfo: {
      title: String,
      authors: [String],
      publisher: String,
      publishedDate: Date,
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

  var Volume = mongoose.model('Volume', VolumeSchema);

  var addVolume = function (volume, callback) {
    volume = new Volume(volume);
    volume.save();
  };

  var listAll = function (callback) {
    Volume.find();
  };

  return {
    addVolume: addVolume,
    Volume: Volume
  };
};