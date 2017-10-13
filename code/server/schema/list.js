/* jshint indent: 2 */

module.exports = function(sequelize, DataTypes) {
  return sequelize.define('list', {
    id: {
      type: DataTypes.INTEGER(11),
      allowNull: false,
      primaryKey: true,
      autoIncrement: true
    },
    content: {
      type: DataTypes.CHAR(255),
      allowNull: true
    },
    name: {
      type: DataTypes.CHAR(20),
      allowNull: true
    },
    dep_id: {
      type: DataTypes.INTEGER(10),
      allowNull: true,
      references: {
        model: 'department',
        key: 'id'
      }
    },
    date: {
      type: DataTypes.CHAR(30),
      allowNull: true
    },
    number: {
      type: DataTypes.INTEGER(3),
      allowNull: true
    },
    status: {
      type: DataTypes.INTEGER(1).UNSIGNED.ZEROFILL,
      allowNull: true
    },
    diningform: {
      type: DataTypes.STRING(20),
      allowNull: true
    },
    phone: {
      type: DataTypes.INTEGER(20),
      allowNull: true
    },
    standard: {
      type: DataTypes.INTEGER(20),
      allowNull: true
    }
  }, {
    tableName: 'list'
  });
};
