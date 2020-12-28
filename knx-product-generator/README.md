# KNX Product File Generator

## Introduction

The product file generator creates a .knxprod file that can be imported into ETS. I have only tested this with ETS5 but it should also work with ETS4.

Creating such a file happens in 2 steps:

1. Build the underlying XML file that describes the virtual hardware and the application program of the virtual device. It uses manufacturer ID 0x00FA (KNX Association) so your devices will show up there after importing them into your ETS Catalog.
2. Sign the XML file before it can be imported into ETS. This step requires some native methods of your ETS installation to be called, so ETS4 or ETS5 must be installed for this step to succeed.

All of this is not extensively documented by KNX but I found a great deal of inspiration here: https://github.com/thelsing/CreateKnxProd and by looking at other product files from the catalog.

## Getting started

The KNX Product File Generator is invoked from the KNX Device Spring Boot Starter, so just look at the SampleDevice on how to do this.