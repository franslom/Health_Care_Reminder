package com.sourcey.materiallogindemo;

/**
 * Created by Franci Suni on 09/12/16.
 */

public class KohonenFeatureMap extends NeuralNet {
    NeuronMatrix mapLayer;
    NeuronLayer inputLayer;
    WeightMatrix weightMatrix;
    InputMatrix inputMatrix;
    InputValue[] iv;
    int xSize;
    int ySize;
    double activationArea;
    double stopArea;
    double initActivationArea;
    double initLearningRate;

    public KohonenFeatureMap() {
        super.learningCycle = 0;
        super.maxLearningCycles = -1;
        this.initLearningRate = 0.6D;
        super.learningRate = this.initLearningRate;
        this.initActivationArea = (double)(this.xSize >= this.ySize?this.xSize / 2:this.ySize / 2);
        this.activationArea = this.initActivationArea;
        this.stopArea = this.initActivationArea / 10.0D;
        super.stopLearning = false;
        this.resetTime();
    }

    void createMapLayer(int var1) {
        if(this.mapLayer != null) {
            this.mapLayer = null;
        }

        this.mapLayer = new NeuronMatrix(var1);
        this.xSize = var1;
        this.ySize = 0;
    }

    void createMapLayer(int var1, int var2) {
        if(this.mapLayer != null) {
            this.mapLayer = null;
        }

        this.mapLayer = new NeuronMatrix(var1, var2);
        this.xSize = var1;
        this.ySize = var2;
    }

    void connectLayers(InputMatrix var1) {
        this.inputMatrix = var1;
        if(this.inputLayer != null) {
            this.inputLayer = null;
        }

        this.inputLayer = new NeuronLayer(var1.getDimension());
        int var2 = this.mapLayer.size();
        if(this.weightMatrix != null) {
            this.weightMatrix = null;
        }

        this.weightMatrix = new WeightMatrix(this.inputLayer.size(), var2, false);
        if(this.iv != null) {
            this.iv = null;
        }

        this.iv = new InputValue[var2];

        for(int var3 = 0; var3 < this.iv.length; ++var3) {
            this.iv[var3] = var1.getRandomInput();
        }

        this.weightMatrix.init(this.iv, var1.getDimension());
        this.mapLayer.init(this.iv);
    }

    void setInitLearningRate(double var1) {
        this.initLearningRate = var1;
        super.learningRate = var1;
    }

    double getInitLearningRate() {
        return this.initLearningRate;
    }

    void setInitActivationArea(double var1) {
        this.initActivationArea = var1;
        this.activationArea = var1;
    }

    double getInitActivationArea() {
        return this.initActivationArea;
    }

    void setActivationArea(double var1) {
        this.activationArea = var1;
    }

    void setStopArea(double var1) {
        this.stopArea = var1;
    }

    double getStopArea() {
        return this.stopArea;
    }

    double getActivationArea() {
        return this.activationArea;
    }

    int getMapSizeX() {
        return this.xSize;
    }

    int getMapSizeY() {
        return this.ySize;
    }

    int getNumberOfWeights() {
        return this.weightMatrix.size();
    }

    float[][] getWeightValues() {
        return this.weightMatrix.getWeights();
    }

    MapNeuron[] getMapNeurons() {
        return this.mapLayer.getMapNeurons();
    }

    InputValue[] getInputValues() {
        return this.inputMatrix.getInputValues();
    }

    void decreaseActivationArea() {
        double var1 = (double)super.learningCycle * 2.0E-4D;
        this.setLearningRate(this.initLearningRate * Math.exp(-2.0D * var1));
        this.setActivationArea(this.initActivationArea * Math.exp(-5.0D * var1));
    }

    void learn() {
        if(this.activationArea <= this.stopArea || super.learningCycle >= super.maxLearningCycles && super.maxLearningCycles != -1) {
            super.stopLearning = true;
        } else {
            ++super.learningCycle;
            this.inputLayer.setInput(this.inputMatrix.getRandomInput());
            MapNeuron var1 = this.mapLayer.computeActivationCenter(this.inputLayer, this.weightMatrix);
            this.weightMatrix.changeWeightsKFM(this.inputLayer.getOutput(), this.mapLayer.getFeedback(var1, this.activationArea), super.learningRate);
            this.decreaseActivationArea();
        }
    }
}
